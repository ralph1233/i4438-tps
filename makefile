.PHONY: getDeviceIp
.PHONY: buildApp

getDeviceIp:
	python getDeviceIp.py

buildApp:
	cd tp1/ex2 && gradlew installDebug

