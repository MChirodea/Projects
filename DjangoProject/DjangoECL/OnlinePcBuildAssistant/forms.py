from django import forms
global typecl
class LoginForm(forms.Form):
    user = forms.CharField(label = "user")
    password = forms.CharField(label = "password")
    
class RegisterForm(forms.Form):  
    user = forms.CharField(label = "user")
    email = forms.CharField(label = "email")
    password = forms.CharField(label = "password")
    cpassword = forms.CharField(label = "cpassword")  
    
class BuildForm(forms.Form):
    budget = forms.CharField(label = "budget")   
    
class HomeForm(forms.Form):
    favourites = 'Favourites'