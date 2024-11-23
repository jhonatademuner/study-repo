from django.urls import path
from . import views

urlpatterns = [
    path("person/", views.person_list_create, name="person_list_create"),
    path("person/<int:pk>", views.person_detail, name="person_detail"),
    path("", views.person_list, name="person_list"),
    path("", views.home, name="home"),
    path("register", views.register_user, name="register"),
    path("logout", views.logout_user, name="logout"),
    path("add_person/", views.add_person, name="add_person"),
]
