#!/bin/bash
echo "Habilitando serviço netd para inicialização com o sistema."
sudo systemctl enable netd &&
echo "Iniciando serviço netd"
sudo systemctl start netd &&
echo "Habilitando Agente SNMP para inicialização com o sistema"
sudo systemctl enable snmpd.service
echo "Iniciando agente SNMP"
sudo systemctl start snmpd.service
echo "Habilitando daemon LLDP para inicialização com o sistema"
sudo systemctl enable lldpd.service
echo "Iniciando daemon LLDP"
sudo systemctl start lldpd.service
echo "Removendo endereço IPv4 padrao da interface mgmt"
net del vrf mgmt ip address 127.0.0.1/8
echo "Adicionando novo endereço IPv4 a interface mgmt"
net add vrf mgmt ip address 192.168.200.1/24
echo "Adicionando interface swp1"
net add interface swp1
echo -ne "Digite o ip/prefixo para a interface swp1. EX: 192.168.0.1/24\nIP: "; read IPSWP1
net add interface swp1 ip address "$IPSWP1"
echo "Aplicando mudanças"
net commit
echo "Concluído"

