# Generated by Django 2.1.5 on 2019-01-16 17:24

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('OnlinePcBuildAssistant', '0010_auto_20190116_1827'),
    ]

    operations = [
        migrations.AlterField(
            model_name='userbuilds',
            name='userID',
            field=models.CharField(max_length=100),
        ),
    ]
