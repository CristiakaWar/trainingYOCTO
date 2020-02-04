DESCRIPTION = "Dummy recipe for grep 3.4"

SRC_URI = "http://ftp.gnu.org/gnu/${PN}/${PN}-${PV}.tar.xz"

S = "${WORKDIR}/${PN}-${PV}"
B = "${WORKDIR}/build"
D = "${WORKDIR}/install"

addtask do_fetch before do_unpack
do_fetch () {
    wget "${SRC_URI}" -P "${WORKDIR}"
}

addtask do_unpack before do_config after do_fetch
do_unpack () {
    tar xaf "${WORKDIR}/${PN}-${PV}.tar.xz" -C "${WORKDIR}"
}

addtask do_configure before do_compile after do_unpack
do_configure () {
    mkdir -p "${B}"
    cd "${B}"
    "${S}/configure"
}

addtask do_compile before do_install after do_configure
do_compile () {
    cd "${B}"
    make
}

addtask do_install before do_package after do_compile
do_install () {
    mkdir -p "${D}"
    cd "${B}"
    make DESTDIR="${D}" install
}

inherit package_tar
