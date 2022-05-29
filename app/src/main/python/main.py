from os.path import dirname ,join
import pandas as pd
import numpy as np
def specific():
   filename=join(dirname(__file__),"libs2/cars_engage_2022.csv")
   df=pd.read_csv(filename)
   XD=df[['Body_Type','Speedometer','Drivetrain','Fuel_Type','Type']]
   return(XD.value_counts().idxmax())

