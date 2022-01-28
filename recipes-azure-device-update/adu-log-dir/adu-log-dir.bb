# Generates a new temporary directory, /aduc-logs, for ADU Client log files.

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${THISDIR}/../../LICENSE.md;md5=d8264fe5b90c62dcf0dc1b70a04aef2d"

SRC_URI = "\
    file://adu-logs.conf \
"

do_install() {
    install -d ${D}${sysconfdir}/tmpfiles.d
    install -m 0644 ${WORKDIR}/adu-logs.conf ${D}${sysconfdir}/tmpfiles.d
}

FILES_${PN} += "${sysconfdir}/tmpfiles.d/adu-logs.conf"

inherit allarch
