#!/usr/bin/env python
# coding: utf-8

# In[2]:


import numpy as np 
import pandas as pd 
import matplotlib.pyplot


# In[3]:


df=pd.read_csv("C:/Users/aryan/Downloads/cars_engage_2022.csv")


# In[4]:


df


# In[28]:


XD=df[['Body_Type','Speedometer','Drivetrain','Fuel_Type','Type']].value_counts().idxmax()


# In[29]:


XD


# In[30]:


import pickle
pickle.dump(XD,open('model.pkl','wb'))


# In[ ]:




