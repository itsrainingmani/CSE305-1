def hw1(inp, out):
	f = open(inp, 'r')
	l = open(out, 'w')
	out_arr = [[0 for i in range(0, 123)] for i in range(len(f))]
	inp_arr = []
	for line in f:
		inp_arr.append(line)
	for i in range(0,len(f)):
		for j in inp_arr[i]:
			out_arr[i][ord(j)] += 1
		flag = True
		for j in range(97, 123):
			if (out_arr[i][j] < 1):
				flag = False
				break
		if flag == True:
			l.write("true\n")
		else:
			l.write("false\n")
	f.close()
	l.close()
