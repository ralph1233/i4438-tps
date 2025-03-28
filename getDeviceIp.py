import subprocess
import re


def get_device_name():
    try:
        result = subprocess.run(
            ["adb", "shell", "getprop ro.product.model"], capture_output=True, text=True
        )
        return result.stdout.strip()
    except Exception as e:
        return f"Error: {str(e)}"


def get_device_ip():
    try:
        result = subprocess.run(
            ["adb", "shell", "ip -f inet addr show wlan0"],
            capture_output=True,
            text=True,
        )
        match = re.search(r"inet (\d+\.\d+\.\d+\.\d+)", result.stdout)
        return (
            match.group(1) if match else "Could not find device IP. Is ADB connected?"
        )
    except Exception as e:
        return f"Error: {str(e)}"


def connect_to_device(ip):
    try:
        result = subprocess.run(
            ["adb", "connect", f"{ip}:5555"], capture_output=True, text=True
        )
        return result.stdout.strip()
    except Exception as e:
        return f"Error: {str(e)}"


if __name__ == "__main__":
    device_name = get_device_name()

    if device_name == "SM-A025F":
        ip_address = get_device_ip()
        print(f"Device Name: {device_name}")
        print(f"Device IP: {ip_address}")

        if "Could not find" not in ip_address and "Error" not in ip_address:
            connection_result = connect_to_device(ip_address)
            print(connection_result)
        else:
            print("Skipping ADB connect due to IP retrieval failure.")
    else:
        print(f"Device Name: {device_name} (Skipping connection, not SM-A025F)")
