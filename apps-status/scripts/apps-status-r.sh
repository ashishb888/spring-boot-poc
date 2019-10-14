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

finalResult=""

for host in $hosts
do
	#echo -e $(ssh hdpusr@$host 'bash -s' < task.sh $lockFilesDir)
	result=$(ssh hdpusr@$host 'bash -s' < /opt/ngs/ashishb/bash/apps-status/task.sh $lockFilesDir)
	finalResult+=$result"\n"
	#echo -e $result
	#echo -e $result | sed '$d'
done

echo -e $finalResult | sed '$d'
