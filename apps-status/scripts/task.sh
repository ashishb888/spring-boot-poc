#!/bin/bash

lockFilesDir=$1
lineSeperator='^'
hostSeperator='|'

cd $lockFilesDir

result="$HOSTNAME$hostSeperator"

for dir in $(ls -d */); do
        dirName=${dir%/}
        #echo "Checking $dirName application"
        cd $dirName
        cat $dirName.lck | xargs kill -0 > /dev/null 2>&1
        if [ $? -ne 0 ];
        then
                result+="$dirName,stopped$lineSeperator"
        else
                result+="$dirName,running$lineSeperator"
        fi
        cd ..
done

result=${result%?}
#echo -e $result | sed '$d'
echo -e $result

