java -cp target/classes/:$DAIKONDIR/daikon.jar daikon.DynComp richarduggelberg.seppuku.Seppuku

longline1="java -cp target/classes/:$DAIKONDIR/daikon.jar daikon.Chicory"
longline2=" --daikon --comparability-file=Seppuku.decls-DynComp"
longline3=" richarduggelberg.seppuku.Seppuku"

longline="${longline1}${longline2}${longline3}"

$longline > invariants.txt

rm -rf Seppuku.decls-DynComp
rm -rf Seppuku.dtrace.gz

java -cp $DAIKONDIR/daikon.jar daikon.PrintInvariants --format Daikon Seppuku.inv.gz > invariants.txt

rm -rf Seppuku.inv.gz
