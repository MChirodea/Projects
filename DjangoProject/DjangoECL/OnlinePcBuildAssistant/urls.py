'''
Created on Jan 10, 2019

@author: mchir
'''
from django.urls import path
from . import views

urlpatterns = [
        path('login/',views.login,name = 'login'),
        path('register/',views.register,name = 'register'),
        path('home/',views.home ,name = 'home'),
        path('buildpc/build-your-dream-pc',views.buildpc,name = 'buildpc'),
        path('buildpc/favourites',views.favourites,name = 'favourites'),
    ]