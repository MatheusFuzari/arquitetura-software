from django.urls import path
from . import views

urlpatterns = [
    path('', views.indexView, name="index"),
    path('home', views.homeView, name="home"),
    path('cart', views.cartView, name="cart"),
    path('build', views.buildView, name="build")
]