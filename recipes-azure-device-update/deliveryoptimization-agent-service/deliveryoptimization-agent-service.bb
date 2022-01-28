# Installs and configures the DeliveryOptimization Agent Service

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${THISDIR}/../../LICENSE.md;md5=d8264fe5b90c62dcf0dc1b70a04aef2d"

SRC_URI = "\
    file://deliveryoptimization-agent.service \
"

SYSTEMD_SERVICE_${PN} = "deliveryoptimization-agent.service"

do_install_append() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/deliveryoptimization-agent.service ${D}${systemd_system_unitdir}
}

FILES_${PN} += "${systemd_system_unitdir}/deliveryoptimization-agent.service"
REQUIRED_DISTRO_FEATURES = "systemd"
RDEPENDS_${PN} += "deliveryoptimization-agent"

inherit allarch systemd
