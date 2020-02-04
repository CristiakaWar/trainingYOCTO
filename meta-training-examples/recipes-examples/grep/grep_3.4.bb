DESCRIPTION = "Dummy recipe for grep 3.4"

SRC_URI = "http://ftp.gnu.org/gnu/${PN}/${PN}-${PV}.tar.xz"

S = "${WORKDIR}/${PN}-{PV}"

addtask do_fetch before do_unpack
do_fetch () {
    wget "${SRC_URI}" -P "${WORKDIR}"
}

addtask do_unpack before do_config after do_fetch
do_unpack () {
    tar xaf "${WORKDIR}/${PN}-${PV}.tar.xz" -C "${WORKDIR}"
}
