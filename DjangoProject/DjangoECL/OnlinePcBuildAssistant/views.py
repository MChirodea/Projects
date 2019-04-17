from django.shortcuts import render,redirect
from OnlinePcBuildAssistant.forms import LoginForm,RegisterForm,BuildForm
from django.contrib.auth import authenticate
from django.contrib.auth import logout
from django.contrib.auth import login as login_auth
from OnlinePcBuildAssistant.models import *

# Create your views here.
def login(request):
    if(request.method == 'GET'):
        form = LoginForm()
        logout(request)
        return render(request,'login/login.html',{'form':form})
    elif(request.method == 'POST'):
        logF = LoginForm(data=request.POST)
        if(logF.is_valid()):
            user = authenticate(request,username = logF.cleaned_data['user'],password = logF.cleaned_data['password'])
            if(user is not None):
                login_auth(request, user)
                return redirect('/OPBA/home')
            else:
                print("User/Password Incorrect!")
                return redirect('/OPBA/login')
        
def register(request):    
    if(request.method == 'GET'):
        form = RegisterForm()
        return render(request,'register/register.html',{'form':form})
    elif(request.method == 'POST'):
        regF = RegisterForm(data=request.POST)
        if(regF.is_valid()):
            if(regF.cleaned_data['password'] == regF.cleaned_data['cpassword']):
                user = User.objects.create_user(regF.cleaned_data['user'], regF.cleaned_data['email'], regF.cleaned_data['password'])
                user.save()
                return redirect('/OPBA/login')
            else:
                print("Passwords are not matching!")
                return redirect('/OPBA/register')
            
            
def home(request):
    if(request.method == 'POST'):
        if(request.user.get_username() == ''):
            UserBuilds.objects.filter(userID = request.user.get_username()).delete()
        return redirect('/OPBA/buildpc/build-your-dream-pc')
    return render(request,'home/home.html')


def computeTable(request,maxBudget):
    try:
        maxim = 0;
        CPUs = CPU.objects.filter(price__lte = maxBudget)
        MBs = Motherboard.objects.filter(price__lte = maxBudget)
        GPUs = VideoCard.objects.filter(price__lte = maxBudget)       
        RAMs = RAM.objects.filter(price__lte = maxBudget)
        PSUs = PowerSupply.objects.filter(price__lte = maxBudget)
        STs = Storage.objects.filter(price__lte = maxBudget)
        CASEs = Case.objects.filter(price__lte = maxBudget)
        for a in CPUs: 
            for b in MBs: 
                for c in GPUs:
                    for d in RAMs:
                        for e in PSUs:
                            for f in STs:
                                for g in CASEs:
                                    if(a.price + b.price + c.price + d.price + e.price + f.price+ g.price <=maxBudget and a.price + b.price + c.price + d.price + e.price + f.price+ g.price > maxim and a.type.name == b.type.name and c.type.name == b.pcietype.name and d.type.type == b.ramtype.type and a.recomendedWatt + c.recomendedWatt <= e.watts):
                                        maxim = a.price + b.price + c.price + d.price + e.price + f.price+ g.price
                                        cpuO = UserBuilds(userID = request.user.get_username(),name = (a.company.name +' ' + a.name),type = 'CPU',link = a.specs, price = str(a.price))
                                        gpuO = UserBuilds(userID =request.user.get_username(),name = (c.company.name +' ' + c.name),type = 'GPU',link = c.specs,price = str(c.price))
                                        mbO = UserBuilds(userID = request.user.get_username(),name = (b.company.name  +' ' + b.name),type = 'Motherboard',link = b.specs,price =  str(b.price))
                                        ramO = UserBuilds(userID = request.user.get_username(),name = (d.company.name  +' ' + d.name),type = 'RAM',link = d.specs,price = str(d.price))
                                        psuO = UserBuilds(userID = request.user.get_username(),name = (e.company.name +' ' + e.name),type = 'Power Supply',link ="build-your-dream-pc",price = str(e.price))
                                        stO = UserBuilds(userID = request.user.get_username(),name = (f.company.name +' ' + f.name),type = (f.storagetype.name+' Storage'),link ="build-your-dream-pc" ,price = str(f.price))
                                        casO = UserBuilds(userID = request.user.get_username(),name = (g.company.name +' ' + g.name),type = 'Computer Case',link = "build-your-dream-pc",price = str(g.price))
        
       
        
        cpuO.save()
        gpuO.save()
        mbO.save()
        ramO.save()
        psuO.save()
        stO.save()
        casO.save()
    except:
        print("Price too low")    
           
        
def buildpc(request):
    if(request.method == 'GET'):
        form = BuildForm()
        data = UserBuilds.objects.filter(userID = request.user.get_username())
        print(data)
        return render(request,'buildpc/build-your-dream-pc.html',{'form':form,'data':data})

    elif(request.method == 'POST'):
        buildF = BuildForm(data=request.POST)
        if(buildF.is_valid()):
            print('Budget: ' + buildF.cleaned_data['budget'])
            UserBuilds.objects.filter(userID = request.user.get_username()).delete()
            computeTable(request,int(buildF.cleaned_data['budget']))
            return redirect('/OPBA/buildpc/build-your-dream-pc')
 
def favourites(request):
        print(request)
        if(request.user.get_username() == ''):
            UserBuilds.objects.filter(userID = request.user.get_username()).delete()
        data = UserBuilds.objects.filter(userID = request.user.get_username())
        print(data)
        return render(request,'buildpc/favourites.html',{'data':data})
        
