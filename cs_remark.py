
# coding: utf-8

# In[ ]:

import pandas as pd
import numpy as np
lenddate,contract_id,name,csdate,cstime,remark,is_effective,result,phone = ('借款日期', '合同号', '客户姓名', '催收日期', '催收时间','备注', '是否有效联络', '催收结果', '电话')
metadata = pd.read_csv('/Users/yixina-v/zhanghan/data/YRD1609-1612.txt')


# In[ ]:

print metadata.shape
usefulDf = metadata.dropna(0,how='any').drop(['ecif_id','PHONE_RECORD_SID'],axis=1).sort_values(by=[name,contract_id,csdate,cstime])
#metadata = metadata[pd.notnull(metadata[remark]) & pd.notnull(metadata[is_effective]) \
#                    & pd.notnull(metadata[result]) & pd.notnull(metadata[csdate]) ]
print usefulDf.shape
print usefulDf[is_effective].value_counts()
usefulDf[is_effective].value_counts()


# In[136]:

#对于每个人（合同号+姓名）每天有效电话情况
#usefulDf[usefulDf[is_effective]=='Y'].to_csv('r.txt')
#对于每个人（合同号+姓名）每天电话情况
usefulDf[csdate] = usefulDf[csdate].map(lambda x: '{0:.0f}'.format(x))
usefulDf.to_csv('std_cs_record',index=False,header=False)


# In[ ]:

def mergeCSrecord(metadata):
    #metadata['merge'] = metadata.apply(lambda x: '{0:.0f} {1}:{2}:{3}'.format(x[csdate],x[cstime],x[is_effective],x[result]),axis=1)
    #r = metadata[metadata[name]=='王伟'].sort_values(by=[csdate,cstime])[[contract_id,name,'merge']].groupby([contract_id,name]).agg({ \
    r = metadata.sort_values(by=[csdate,cstime]).groupby([contract_id,name]).agg({             'merge': lambda x: '->\n'.join(x)          })
    r
#r.to_csv('r.txt',index=False)

