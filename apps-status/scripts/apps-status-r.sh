#!/bin/bash

#title           :
#description     :
#author          :Ashish Bhosle

baseDir=/opt/ngs/ashishb/bash/apps-status
yamlFile=$baseDir/apps-status.yml

# include parseYaml function
. $baseDir/parse-yaml.sh

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
	result=$(ssh $host 'bash -s' < $baseDir/task.sh $lockFilesDir)
	finalResult+=$result"\n"
done

echo -e $finalResult | sed '$d'
