#!/bin/bash

#title           :
#description     :
#author          :Ashish Bhosle

baseDir=/opt/ngs/ashishb/bash/wait-on-touch
yamlFile=$baseDir/wait-on-touch.yml

# include parseYaml function
. $baseDir/parse-yaml.sh

# read yaml file
eval $(parseYaml $yamlFile "config_")

directory=$config_directory
hosts=$config_hosts

if [ -z $directory ]
then
        echo "Please set corresponding parent directory in properties file"
        exit 1
fi

finalResult=0

for host in $hosts
do
	result=$(ssh $host 'bash -s' < $baseDir/task.sh $directory)
	#expr $finalResult + $result
	let "finalResult += $result"
done

echo -e $finalResult
