;;;; define templates

(deftemplate issues (slot issue))

(deftemplate reasons (slot reason))

(deftemplate solutions (slot solution))

;;;;; define rules

(defrule rule1(issues {issue == "can’t turn on"})=> (assert (reasons (reason "no power"))))

(defrule rule2(reasons {reason == "no power"})=> (assert (solutions (solution "connect power cable"))))

(defrule rule3(issues {issue == "error message before splash screen"})=> (assert (reasons (reason "There is virus"))))

(defrule rule4(reasons {reason == "There is virus"})=> (assert (solutions (solution "defender program"))))

(defrule rule5(issues {issue == "error message after splash screen"})=> (assert (reasons (reason "hard disk problem"))))

(defrule rule6(reasons {reason == "hard disk problem"})=> (assert (solutions (solution "change HDD"))))

(defrule rule7(issues {issue == "shut down itself"})=> (assert (reasons (reason "updating"))))

(defrule rule8(reasons {reason == "updating"})=> (assert (solutions (solution "wait"))))

(defrule rule9(issues {issue == "continue beep noise"})=> (assert (solutions (solution "expert engineer"))))

(defrule rule10(issues {issue == "can’t open a specific file"})=> (assert (reasons (reason "haven’t common program"))))

(defrule rule11(reasons {reason == "haven’t common program"})=> (assert (solutions (solution "download program"))))

(defrule rule12(issues {issue == "blue screen of death"})=> (assert (reasons (reason "crash error"))))

(defrule rule13(reasons {reason == "crash error"})=> (assert (solutions (solution "error code and search in the internet"))))

(defrule rule14(issues {issue == "dll message problem"})=> (assert (reasons (reason "dll file missing"))))

(defrule rule15(reasons {reason == "dll file missing"})=> (assert (solutions (solution "use system file checker"))))

(defrule rule16(issues {issue == "app run slowly"})=> (assert (reasons (reason "ram small size"))))

(defrule rule17(reasons {reason == "ram small size"})=> (assert (solutions (solution "increase ram size"))))

(defrule rule18(issues {issue == "malware message"})=> (assert (reasons (reason "encryption virus"))))

(defrule rule19(reasons {reason == "encryption virus"})=> (assert (solutions (solution "format the hard and use data recovery program"))))

(defrule rule20(issues {issue == "internet connectivity"})=> (assert (reasons (reason "internet service provider"))))

(defrule rule21(reasons {reason == "internet service provider"})=> (assert (solutions (solution "connect manually to DNS"))))

(defrule rule22(issues {issue == "hard disk failure"})=> (assert (reasons (reason "bad sectors"))))

(defrule rule23(reasons {reason == "bad sectors"})=> (assert (solutions (solution "change HDD"))))

(defrule rule24(issues {issue == "noise from hard disk"})=> (assert (reasons (reason "hard disk problem"))))

(defrule rule25(issues {issue == "frozen screen of app"})=> (assert (reasons (reason "bug in app"))))

(defrule rule26(reasons {reason == "bug in app"})=> (assert (solutions (solution "raster the app"))))

(defrule rule27(issues {issue == "overheating"})=> (assert (reasons (reason "fan stop suddenly"))))

(defrule rule28(reasons {reason == "fan stop suddenly"})=> (assert (solutions (solution "change fan"))))

(defrule rule29(issues {issue == "message CPU overheat"})=> (assert (reasons (reason "overheating"))))

(defrule rule30(reasons {reason == "overheating"})=> (assert (solutions (solution "change fan"))))

(defrule rule31(issues {issue == "application won't install"})=> (assert (reasons (reason "program requirement problem"))))

(defrule rule32(reasons {reason == "program requirement problem"})=> (assert (solutions (solution "download version of program suitable for pc"))))

(defrule rule33(issues {issue == "peripherals stop working"})=> (assert (reasons (reason "driver dropped"))))

(defrule rule34(reasons {reason == "driver dropped"})=> (assert (solutions (solution "download drivers"))))

(defrule rule35(issues {issue == "peripherals not working "})=> (assert (reasons (reason "cable problem"))))

(defrule rule36(reasons {reason == "cable problem"})=> (assert (solutions (solution "change peripherals by new one"))))

(defrule rule37(issues {issue == "not use maximum RAM"})=> (assert (reasons (reason "RAM not connect correct"))))

(defrule rule38(reasons {reason == "RAM not connect correct"})=> (assert (solutions (solution "put RAM in the right slot"))))

(defrule rule39(issues {issue == "crash before loading OS"})=> (assert (reasons (reason "OS dropped"))))

(defrule rule40(reasons {reason == "OS dropped"})=> (assert (solutions (solution "install new OS"))))

(defrule rule41(issues {issue == "monitor show boot up and stop"})=> (assert (reasons (reason "graphic driver dropped"))))

(defrule rule42(reasons {reason == "graphic driver dropped"})=> (assert (solutions (solution "install graphic driver"))))

(defrule rule43(issues {issue == "monitor connect but not showing image"})=> (assert (reasons (reason "monitor cable not connect"))))

(defrule rule44(reasons {reason == "monitor cable not connect"})=> (assert (solutions (solution "connect monitor cable with PC"))))

(defrule rule45(issues {issue == "internet slow"})=> (assert (reasons (reason "many cookies"))))

(defrule rule46(reasons {reason == "many cookies"})=> (assert (solutions (solution "remove temporary files of browser"))))

(defrule rule47(issues {issue == "keyboard write wrong"})=> (assert (reasons (reason "keyboard format"))))

(defrule rule48(reasons {reason == "keyboard format"})=> (assert (solutions (solution "change the format to suitable for your country"))))

(defrule rule49(issues {issue == "window slow booting"})=> (assert (reasons (reason "many programs load up"))))

(defrule rule50(reasons {reason == "many programs load up"})=> (assert (solutions (solution "prevent program from startup at task manger"))))

(defrule rule51(issues {issue == "windows not update successfully"})=> (assert (reasons (reason "update of program cannot install"))))

(defrule rule52(reasons {reason == "update of program cannot install"})=> (assert (solutions (solution "download update from program website"))))

(defrule rule53(issues {issue == "app command not work"})=> (assert (reasons (reason "app not work"))))

(defrule rule54(reasons {reason == "app not work"})=> (assert (solutions (solution "reinstall app"))))

(defrule rule55(issues {issue == "apps command not work"})=> (assert (reasons (reason "apps not work"))))

(defrule rule56(reasons {reason == "apps not work"})=> (assert (solutions (solution "expert engineer"))))

(defrule rule57(issues {issue == "download take long time"})=> (assert (reasons (reason "internet slow"))))

(defrule rule58(reasons {reason == "internet slow"})=> (assert (solutions (solution "renew the subscription"))))

(defrule rule59(issues {issue == "download disconnect many times"})=> (assert (reasons (reason "internet card problem"))))

(defrule rule60(reasons {reason == "internet card problem"})=> (assert (solutions (solution "update the internet card"))))

(defrule rule61(issues {issue == "pop-up ads appearing on desktop"})=> (assert (reasons (reason "adware virus"))))

(defrule rule62(reasons {reason == "adware virus"})=> (assert (solutions (solution "download ad defender"))))

(defrule rule63(issues {issue == "problem website certification"})=> (assert (reasons (reason "clock battery damaged"))))

(defrule rule64(reasons {reason == "clock battery damaged"})=> (assert (solutions (solution "change the battery and change time and date"))))

(defrule rule65(issues {issue == "printer won't print"})=> (assert (reasons (reason "driver not up to date"))))

(defrule rule66(reasons {reason == "driver not up to date"})=> (assert (solutions (solution "update printer driver"))))

(defrule rule67(issues {issue == "printer work and stop"})=> (assert (reasons (reason "printer crash"))))

(defrule rule68(reasons {reason == "printer crash"})=> (assert (solutions (solution "repower printer"))))

(defrule rule69(issues {issue == "error 404 page not found"})=> (assert (reasons (reason "address wrong"))))

(defrule rule70(reasons {reason == "address wrong"})=> (assert (solutions (solution "rewrite address correctly"))))

(defrule rule71(issues {issue == "get data loses"})=> (assert (solutions (solution "download recovery data program"))))

(defrule rule72(issues {issue == "parameter is incorrect"})=> (assert (reasons (reason "USB port not work"))))

(defrule rule73(reasons {reason == "USB port not work"})=> (assert (solutions (solution "update USB driver"))))

(defrule rule74(issues {issue == "disk full message"})=> (assert (reasons (reason "your data fill hard disk"))))

(defrule rule75(reasons {reason == "your data fill hard disk"})=> (assert (solutions (solution "get external hard disk"))))

(defrule rule76(issues {issue == "manufacturing fault"})=> (assert (reasons (reason "hard disk not tested"))))

(defrule rule77(reasons {reason == "hard disk not tested"})=> (assert (solutions (solution "buy new disk and test it before use"))))

(defrule rule78(issues {issue == "port conflict problem"})=> (assert (reasons (reason "two software use the same port"))))

(defrule rule79(reasons {reason == "two software use the same port"})=> (assert (solutions (solution "change one of ports of two software"))))

(defrule rule80(issues {issue == "full disk system"})=> (assert (reasons (reason "no space in disk system"))))

(defrule rule81(reasons {reason == "no space in disk system"})=> (assert (solutions (solution "remove temporary files"))))

(defrule rule82(issues {issue == "data loses"})=> (assert (reasons (reason "create new disk"))))

(defrule rule83(reasons {reason == "create new disk"})=> (assert (solutions (solution "download disk organize program"))))

(defrule rule84(issues {issue == "some windows tools not work"})=> (assert (reasons (reason "activation windows"))))

(defrule rule85(reasons {reason == "activation windows"})=> (assert (solutions (solution "get activation key from Microsoft website"))))

(defrule rule86(solutions { solution == "connect power cable"} )=> (printout t "connect power cable" crlf) )

(defrule rule87(solutions { solution == "Defender program"} )=> (printout t "Defender program" crlf) )

(defrule rule88(solutions { solution == "change HDD"} )=> (printout t "change HDD" crlf) )

(defrule rule89(solutions { solution == "expert engineer"} )=> (printout t "expert engineer" crlf) )

(defrule rule90(solutions { solution == "wait"} )=> (printout t "wait" crlf) )

(defrule rule91(solutions { solution == "download program"} )=> (printout t "download program" crlf) )

(defrule rule92(solutions { solution == "use system file checker"} )=> (printout t "use file checker system" crlf))

(defrule rule93(solutions { solution == "increase RAM size"} )=> (printout t "increase RAM size" crlf) )

(defrule rule94(solutions { solution == "format the hard and use data recovery program"} )=> (printout t "format the hard and use data recovery program" crlf) )

(defrule rule95(solutions { solution == "connect manually to DNS"} )=> (printout t "connect manually to DNS" crlf) )

(defrule rule96(solutions { solution == "raster the app"} )=> (printout t "raster app" crlf) )

(defrule rule97(solutions { solution == "change fan"} )=> (printout t "change fan" crlf) )

(defrule rule98(solutions { solution == "download version of program suitable for pc"} )=> (printout t "download version of program suitable for pc" crlf) )

(defrule rule99(solutions { solution == "download drivers"} )=> (printout t "download drivers" crlf) )

(defrule rule100(solutions { solution == "change peripherals by new one"} )=> (printout t "change peripherals by new one" crlf) )

(defrule rule101(solutions { solution == "put RAM in right slot"} )=> (printout t "put RAM in right slot" crlf) )

(defrule rule102(solutions { solution == "install new OS"} )=> (printout t "install new OS" crlf) )

(defrule rule103(solutions { solution == "install graphic driver"} )=> (printout t "install graphic driver" crlf) )

(defrule rule104(solutions { solution == "connect monitor cable with PC"} )=> (printout t "connect monitor cable with PC" crlf) )

(defrule rule105(solutions { solution == "remove temporary files of browser"} )=> (printout t "remove temporary files of browser" crlf) )

(defrule rule106(solutions { solution == "change the format to suitable for your country"} )=> (printout t "change the format to suitable for your country" crlf) )

(defrule rule107(solutions { solution == "prevent program from startup at task manger"} )=> (printout t "prevent program from startup at task manger" crlf) )

(defrule rule108(solutions { solution == "download update from program website"} )=> (printout t "download update from program website" crlf) )

(defrule rule109(solutions { solution == "reinstall app"} )=> (printout t "reinstall app" crlf) )

(defrule rule110(solutions { solution == "renew the subscription"} )=> (printout t "renew the subscription" crlf) )

(defrule rule111(solutions { solution == "update the internet card"} )=> (printout t "update the internet card" crlf) )

(defrule rule112(solutions { solution == "download ad defender"} )=> (printout t "download ad defender" crlf) )

(defrule rule113(solutions { solution == "change the battery and change time and date"} )=> (printout t "change the battery and change time and date" crlf) )

(defrule rule114(solutions { solution == "update printer driver"} )=> (printout t "update printer driver" crlf) )

(defrule rule115(solutions { solution == "repower the printer"} )=> (printout t "repower the printer" crlf) )

(defrule rule116(solutions { solution == "rewrite address correctly"} )=> (printout t "rewrite address correctly" crlf) )

(defrule rule117(solutions { solution == "download recovery data program"} )=> (printout t "download recovery data program" crlf) )

(defrule rule118(solutions { solution == "update USB driver"} )=> (printout t "update USB driver" crlf) )

(defrule rule119(solutions { solution == "get external hard disk"} )=> (printout t "get external hard disk" crlf) )

(defrule rule120(solutions { solution == "buy new disk and test it before use"} )=> (printout t "buy new disk and test it before use" crlf) )

(defrule rule121(solutions { solution == "change one of ports of two software"} )=> (printout t "change one of ports of two software" crlf) )

(defrule rule122(solutions { solution == "remove temporary files"} )=> (printout t "remove temporary files" crlf) )

(defrule rule123(solutions { solution == "get activation key from Microsoft website"} )=> (printout t "get activation key from Microsoft website" crlf) )

(defrule rule124(solutions { solution == "error code and search in the internet"} ) => (printout t "error code and search in the internet" crlf) )
