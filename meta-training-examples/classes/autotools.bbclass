
B = "${WORKDIR}/build"
D = "${WORKDIR}/install"

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

