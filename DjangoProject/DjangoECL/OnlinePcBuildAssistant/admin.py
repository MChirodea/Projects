from django.contrib import admin
from OnlinePcBuildAssistant.models import Socket,RamType,Company,Interface,PCIeType,VideoCard,RAM,Motherboard,StorageType,Storage,PowerSupply,Case,CPU,UserBuilds

admin.site.register(Socket)
admin.site.register(RamType)
admin.site.register(Company)
admin.site.register(Interface)
admin.site.register(PCIeType)
admin.site.register(VideoCard)
admin.site.register(RAM)
admin.site.register(CPU)
admin.site.register(Motherboard)
admin.site.register(StorageType)
admin.site.register(Storage)
admin.site.register(PowerSupply)
admin.site.register(Case)
admin.site.register(UserBuilds)
# Register your models here.
