#!/bin/bash

#title           :start.sh
#description     :This script will monitor the locks dir.
#author          :Ashish Bhosle

yamlFile=/opt/ngs/ashishb/bash/apps-status/apps-status.yml

# include parseYaml function
. /opt/ngs/ashishb/bash/apps-status/parse-yaml.sh

# read yaml file
eval $(parseYaml $yamlFile "config_")


lockFilesDir=$config_lockFilesDir
hosts=$config_hosts

if [ -z $lockFilesDir ]
then
        echo "Please set corresponding parent directory in properties file"
        exit 1
fi


cd $lockFilesDir

result=""

for dir in $(ls -d */); do
	dirName=${dir%/}
	#echo "Checking $dirName application"
	cd $dirName
	cat $dirName.lck | xargs kill -0 > /dev/null 2>&1
	if [ $? -ne 0 ];
	then
		result+="$dirName,stopped\n"
	else
		result+="$dirName,running\n"
	fi
	cd ..
done

echo -e $result | sed '$d'

