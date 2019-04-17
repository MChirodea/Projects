from django.db import models
from django.db.models.deletion import CASCADE
from django.contrib.auth.models import User
# Declaratii tabele
# Create your models here.

class Socket(models.Model):
    name = models.CharField(max_length = 100)
    def __str__(self):
        return '{}'.format(self.name)
    class Meta:
        verbose_name = 'Socket'
        verbose_name_plural = 'Socket List'

class RamType(models.Model):
    type = models.CharField(max_length = 100)
    def __str__(self):
        return '{}'.format(self.type)
    class Meta:
        verbose_name = 'RAM Type'
        verbose_name_plural = 'RAM Types'    
        
class Company(models.Model):
    name = models.CharField(max_length = 100)
    def __str__(self):
        return '{}'.format(self.name)
    class Meta:
        verbose_name = 'Company'
        verbose_name_plural = 'Companies'   
        
class Interface(models.Model):
    name = models.CharField(max_length = 100)
    def __str__(self):
        return '{}'.format(self.name)
    class Meta:
        verbose_name = 'Interface'
        verbose_name_plural = 'Interface List' 
        
class PCIeType(models.Model):
    name = models.CharField(max_length = 100)
    def __str__(self):
        return '{}'.format(self.name)
    class Meta:
        verbose_name = 'PCIe Type'
        verbose_name_plural = 'PCIe Types' 
        
class VideoCard(models.Model):
    type = models.ForeignKey(PCIeType, on_delete= CASCADE)
    specs = models.CharField(max_length = 500)
    name = models.CharField(max_length = 100)
    price = models.IntegerField()
    company =  models.ForeignKey(Company, on_delete= CASCADE)
    recomendedWatt = models.IntegerField()
    def __str__(self):
        return '{}'.format(self.company.name +" " +self.name)
    class Meta:
        verbose_name = 'GPU'
        verbose_name_plural = 'GPU List'                              

class RAM(models.Model):
    name = models.CharField(max_length = 100)
    price = models.IntegerField()
    specs = models.CharField(max_length = 500)
    type = models.ForeignKey(RamType, on_delete= CASCADE)
    company =  models.ForeignKey(Company, on_delete= CASCADE)
    def __str__(self):
        return '{}'.format(self.company.name +" " +self.name)
    class Meta:
        verbose_name = 'RAM'
        verbose_name_plural = 'RAM List'
        
class Motherboard(models.Model):
    name = models.CharField(max_length = 100)
    price = models.IntegerField()
    company =  models.ForeignKey(Company, on_delete= CASCADE)
    type = models.ForeignKey(Socket, on_delete= CASCADE)
    specs = models.CharField(max_length = 500)
    ramtype = models.ForeignKey(RamType, on_delete= CASCADE)
    storageinterface = models.ForeignKey(Interface, on_delete= CASCADE)
    pcietype = models.ForeignKey(PCIeType, on_delete= CASCADE)
    def __str__(self):
        return '{}'.format(self.company.name +" " +self.name)
    class Meta:
        verbose_name = 'Motherboard'
        verbose_name_plural = 'Motherboard List'
        
class PowerSupply(models.Model):
    name = models.CharField(max_length = 100)
    price = models.IntegerField()
    watts = models.IntegerField()
    company =  models.ForeignKey(Company, on_delete= CASCADE)
    specs = models.CharField(max_length = 500)
    def __str__(self):
        return '{}'.format(self.company.name +" " +self.name)
    class Meta:
        verbose_name = 'Power Supply'
        verbose_name_plural = 'Power Supply List'    


class StorageType(models.Model):
    name = models.CharField(max_length = 100)
    def __str__(self):
        return '{}'.format(self.name)
    class Meta:
        verbose_name = 'Storage Type'
        verbose_name_plural = 'Storage Types'    

class Storage(models.Model):
    name = models.CharField(max_length = 100)
    price = models.IntegerField()
    storagetype =  models.ForeignKey(StorageType, on_delete= CASCADE)
    type =  models.ForeignKey(Interface, on_delete= CASCADE)
    company = models.ForeignKey(Company, on_delete = CASCADE)
    def __str__(self):
        return '{}'.format(self.company.name +" " +self.name)
    class Meta:
        verbose_name = 'Storage'
        verbose_name_plural = 'Storage List'    

class Case(models.Model):
    name = models.CharField(max_length = 100)
    price = models.IntegerField()
    company =  models.ForeignKey(Company, on_delete= CASCADE)
    def __str__(self):
        return '{}'.format(self.company.name +" " +self.name)
    class Meta:
        verbose_name = 'Case'
        verbose_name_plural = 'Case List'    


class CPU(models.Model):
    name = models.CharField(max_length = 100)
    price = models.IntegerField()
    type = models.ForeignKey(Socket, on_delete= CASCADE)
    specs = models.CharField(max_length = 500)
    company =  models.ForeignKey(Company, on_delete= CASCADE)
    recomendedWatt = models.IntegerField()
    def __str__(self):
        return '{}'.format(self.company.name +" " +self.name)
    class Meta:
        verbose_name = 'CPU'
        verbose_name_plural = 'CPU List'
 
class UserBuilds(models.Model):
    userID = models.CharField(max_length = 100)
    name = models.CharField(max_length = 100)
    link = models.CharField(max_length = 1000)
    type = models.CharField(max_length = 100)
    price = models.CharField(max_length = 100)
    def __str__(self):
        return '{}'.format('Part ' +self.name +' ' +self.userID)
    class Meta:
        verbose_name = 'User Build'
        verbose_name_plural = 'User Builds'
        
