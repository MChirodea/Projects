# Generated by Django 2.1.5 on 2019-01-16 16:27

from django.db import migrations


class Migration(migrations.Migration):

    dependencies = [
        ('OnlinePcBuildAssistant', '0009_powersupply_wattage'),
    ]

    operations = [
        migrations.RenameField(
            model_name='powersupply',
            old_name='wattage',
            new_name='watts',
        ),
    ]