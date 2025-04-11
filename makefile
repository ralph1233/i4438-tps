.PHONY: getDeviceIp
.PHONY: buildApp

getDeviceIp:
	python getDeviceIp.py

buildApp:
	cd tp4/ex1 && gradlew installDebug
