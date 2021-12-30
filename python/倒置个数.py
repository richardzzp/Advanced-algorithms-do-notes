def merge(l_arr, r_arr, num):
    res_arr = []
    i, j = 0, 0
    while i < len(l_arr) and j < len(r_arr):
        if l_arr[i] <= r_arr[j]:
            res_arr.append(l_arr[i])
            i += 1
        else:
            res_arr.append(r_arr[j])
            num += len(l_arr) - i
            j += 1
    if i < len(l_arr):
        res_arr = res_arr + l_arr[i:]
    if j < len(r_arr):
        res_arr = res_arr + r_arr[j:]
    return res_arr, num


def my_sort(arr):
    if len(arr) <= 1:
        return arr, 0
    m = len(arr) >> 1
    l_arr, l_num = my_sort(arr[:m])
    r_arr, r_num = my_sort(arr[m:])
    return merge(l_arr, r_arr, (l_num + r_num))


if __name__ == '__main__':
    case_num = int(input().strip())
    for i in range(case_num):
        _ = input()
        arr = [int(x) for x in input().strip().split(" ")]
        _, num = my_sort(arr)
        print(num)

