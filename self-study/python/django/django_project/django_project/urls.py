from django.contrib import admin
from django.urls import path, include

urlpatterns = [
    path('admin/', admin.site.urls),
    path('', include('person.urls')),  # Replace 'your_app_name' with your app's name
]
