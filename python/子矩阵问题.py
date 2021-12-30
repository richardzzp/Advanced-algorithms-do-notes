def get_maxArea(height):
    stack = []
    area = 0
    for i in range(len(height)):
        while len(stack) != 0 and height[stack[-1]] >= height[i]:  # 当前元素值比栈顶元素对应值小时，出栈
            j = stack.pop()
            k = -1 if len(stack) == 0 else stack[-1]
            if (i - k - 1) * height[j] > area:
                area = (i - k - 1) * height[j]
        stack.append(i)
    while len(stack):
        j = stack.pop()
        k = -1 if len(stack) == 0 else stack[-1]
        area = max((len(height) - k - 1) * height[j], area)  # 此时右边界为栈的长度（即height的最右边）
    return area


if __name__ == '__main__':
    nums = int(input())
    for i in range(nums):
        a, b = map(int, input().split())
        maxArea = 0
        lis = []
        for j in range(a):
            lis.append(list(map(int, input().split())))  # 构建矩阵二维列表
        height = [0 for x in range(b)]
        # 遍历求height数组，并求最大面积
        for i in range(a):
            for j in range(b):
                if lis[i][j] == 0:
                    height[j] = 0
                else:
                    height[j] += 1
            maxArea = max(get_maxArea(height), maxArea)
        print(maxArea)

