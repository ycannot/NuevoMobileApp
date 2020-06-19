echo "Post build proccess has been started"
#./gradlew assembleDebug
$APPCENTER_SOURCE_DIRECTORY/gradlew assembleReleaseAndroidTest


appcenter test run espresso \
--app "Nuevo-Deneme/Nuevo-Deneme-App" \
--devices "Nuevo-Deneme/android-test-set" \
--app-path $APPCENTER_OUTPUT_DIRECTORY/app-release.apk \
--test-series "denemetestseries" \
--locale "en_US" \
--build-dir $APPCENTER_SOURCE_DIRECTORY/app/build/outputs/apk/androidTest/release \
--token $UITEST_TOKEN \
--async \
