.PHONY: getDeviceIp
.PHONY: buildApp

getDeviceIp:
	python getDeviceIp.py

buildApp:
	cd tp3/ex2 && gradlew installDebug
