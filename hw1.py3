def pangram(inp, out):
	out_arr = [[0 for i in range(0, 128)] for i in range(5)]
	inp_arr = []
	f = open(inp, 'r')
	l = open(out, 'w')
	for line in f:
		inp_arr.append(line)
	for i in range(0,5):
		for j in inp_arr[i]:
			out_arr[i][ord(j)] += 1
		flag = True
		for j in range(97, 128):
			if (out_arr[i][j] < 1):
				flag = False
				break
		if flag == True:
			l.write("true\n")
		else:
			l.write("false\n")
	f.close()
	l.close()


pangram("sample_input_1.txt", "output_1.txt")