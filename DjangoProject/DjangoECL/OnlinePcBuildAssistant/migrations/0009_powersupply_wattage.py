# Generated by Django 2.1.5 on 2019-01-16 16:27

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('OnlinePcBuildAssistant', '0008_auto_20190116_1825'),
    ]

    operations = [
        migrations.AddField(
            model_name='powersupply',
            name='wattage',
            field=models.IntegerField(default=0),
            preserve_default=False,
        ),
    ]
