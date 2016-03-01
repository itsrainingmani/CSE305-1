fun member (x, nil) = false | member (x, y::ys) = x=y orelse member (x, ys);

fun pangram (temp, count, kittens) = 
	if count < 26 andalso temp > #"z" then "false\n"
	else
		if count = 26 then "true\n"
		else
			if member(temp, kittens) = true then pangram(chr(ord(temp) + 1), count + 1, kittens)
			else "false\n"

fun hw1(inFile : string, outFile : string) =
let
	val inStream = TextIO.openIn inFile
	val outStream = TextIO.openOut outFile
	val readLine = TextIO.inputLine inStream
	fun helper(readLine : string option) = 
		case readLine of
				NONE => ( TextIO.closeIn inStream; TextIO.closeOut outStream)
				| SOME(c) => ( TextIO.output(outStream, pangram(#"a", 0, explode(c)));
				helper(TextIO.inputLine inStream))
in 
	helper(readLine)
end