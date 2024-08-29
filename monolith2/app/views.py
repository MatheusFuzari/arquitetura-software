from django.shortcuts import render
from django.http import HttpResponse
from django.template import loader
# Create your views here.

def indexView(request):
    print('socorro')

    return render(request, 'teste.html')

def homeView(request):
    print('socorro')

    data = {
        'username': 'Fuzari'
    }

    return render(request, 'home.html', data)

def cartView(request):
    print('socorro')

    if(request.method == 'POST'):
        print(request.POST['name'])

    return render(request, 'cart.html')

def buildView(request):
    print('socorro')

    return render(request, 'build.html')