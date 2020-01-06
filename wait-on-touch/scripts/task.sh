#!/bin/bash

directory=$1

result=`ls -1q $directory | wc -l`
echo -e $result

