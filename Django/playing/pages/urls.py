# pages/urls.py
from django.urls import path
from .views import homePageView # our lovely view function 

urlpatterns = [path("", homePageView, name="home")]