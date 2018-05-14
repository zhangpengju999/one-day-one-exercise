class Node():
    def __init__(self,data=None,left=None,right=None):
        self.left = left
        self.right = right
        self.data = data

def create(root,datalist,i):
    if i<len(datalist):
        root = Node(data=datalist[i])
        root.left = create(root.left,datalist,2*i+1)
        root.right = create(root.right,datalist,2*i+2)
        return root
    return root

def find_path(root,k):
    if root == None:
        return []
    if root.data == k:
        return [root.data]
    s = find_path(root.left, k)
    if s:
        return [root.data] + s
    s = find_path(root.right, k)
    if s:
        return [root.data] + s
    return []

def LCA(root,data1,data2):
    s1 = find_path(root,data1)
    s2 = find_path(root,data2)
    l = min(len(s1),len(s2));
    for i in range(0,l):
        if(s1[i] == s2[i]):
            d = s1[i]
        else:
            break;
    print ('LCA node:%s'%(d))

if __name__ == '__main__':
    root = Node()
    list = ['1','2','3','4','5','6','7','8']
    root = create(root,list,0)
    print(root.data,root.left,root.right)
    LCA(root,'6','7')