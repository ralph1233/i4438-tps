.PHONY: getDeviceIp
.PHONY: buildApp

getDeviceIp:
	python getDeviceIp.py

buildApp:
	cd sessions/20232024 && gradlew installDebug