echo "BEGIN PreBuild Script"

 

echo "Updating build.gradle..."
IdFile=$BUILD_REPOSITORY_LOCALPATH/app/build.gradle
echo "IdFile=" $IdFile
sed -i '' "s/APPCENTER_APP_ID/$APPCENTER_APP_ID/g" $IdFile
sed -i '' "s/APPCENTER_KEYSTORE_PASSWORD/$APPCENTER_KEYSTORE_PASSWORD/g" $IdFile
sed -i '' "s/APPCENTER_KEY_ALIAS/$APPCENTER_KEY_ALIAS/g" $IdFile
echo "After string replace:"
cat $IdFile
echo "END Updating build.gradle"

 

echo "END PreBuild Script"