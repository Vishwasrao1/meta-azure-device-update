# Installs the ADU Agent Service that will auto-start the ADU Agent
# and pass in the IoT Hub connection string located at /boot/iot-con-string.txt.

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${THISDIR}/../../LICENSE.md;md5=d8264fe5b90c62dcf0dc1b70a04aef2d"

SRC_URI = "\
    file://adu-agent.service \
"

SYSTEMD_SERVICE_${PN} = "adu-agent.service"

do_install_append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/adu-agent.service ${D}${systemd_system_unitdir}
}

FILES_${PN} += "${systemd_system_unitdir}/adu-agent.service"

REQUIRED_DISTRO_FEATURES = "systemd"

DEPENDS += "azure-device-update deliveryoptimization-agent-service"

RDEPENDS_${PN} += "azure-device-update deliveryoptimization-agent-service"

inherit allarch systemd
