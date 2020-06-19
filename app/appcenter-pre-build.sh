echo "BEGIN PreBuild Script"

 

echo "BEGIN Updating APPCENTER_APP_ID in app/build.gradle with value: " $APPCENTER_APP_ID
IdFile=$BUILD_REPOSITORY_LOCALPATH/app/build.gradle
echo "IdFile=" $IdFile
sed -i '' "s/APPCENTER_APP_ID/$APPCENTER_APP_ID/g" $IdFile
echo "After string replace:"
cat $IdFile
echo "END Updating APPCENTER_APP_ID in app/build.gradle with value: " $APPCENTER_APP_ID

 

echo "END PreBuild Script"