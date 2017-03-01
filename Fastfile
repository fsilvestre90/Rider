# More documentation about how to customize your build
# can be found here:
# https://docs.fastlane.tools
fastlane_version "1.109.0"

# This value helps us track success metrics for Fastfiles
# we automatically generate. Feel free to remove this line
# once you get things running smoothly!
generated_fastfile_id "8b0bb5f6-4f3e-4b98-a316-3e960af64b0f"

default_platform :android

# Fastfile actions accept additional configuration, but
# don't worry, fastlane will prompt you for required
# info which you can add here later
lane :beta do
  # build the release variant
  gradle(task: "assembleRelease")

  # upload to Beta by Crashlytics
  crashlytics(
    api_token: "ee1f195560047f5b5d63a8174fb6529714a7fc28",
    build_secret: "d3a32e0a3daa214111c29166f253335631afaacd76ee915730a3742822fd597a"
  )

  gradle(
        project_dir: "./app",
        task: "lint#{app_variant}Beta",
        flags: "--info"
      )
end
