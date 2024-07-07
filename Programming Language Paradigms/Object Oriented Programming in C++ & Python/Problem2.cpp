#include <iostream>
using namespace std;

class CPU{
    private:
        int clock_frequency;
        string instruction_set_architecture;
        int type;
        int no_registers;
        string manufacturer;

    public:
        CPU(int clock_frequency, string instruction_set_architecture, int type, int no_registers, string manufacturer): clock_frequency(clock_frequency),instruction_set_architecture(instruction_set_architecture),type(type),no_registers(no_registers),manufacturer(manufacturer){}
        ~CPU(){}
        int getClockFrequency()const{return clock_frequency;}
        string getInstructionSetArch()const{return instruction_set_architecture;}
        int getType()const{return type;}
        int getNoRegisters()const{return no_registers;}
        string getManufacturer()const{return manufacturer;}
};

class RAM{
    private:
        int size;
        string type;
        string manufacturer;
    public:
        RAM(int s, string t, string m): size(s),type(t),manufacturer(m){}
        ~RAM(){}
        int getSize()const{return size;}
        string getType()const{return type;}
        string getManufacturer()const{return manufacturer;}
};

class HardDisk{
    private:
        int size;
        int rotations_per_min;
        string manufacturer;
    public:
        HardDisk(int s, int r, string m): size(s),rotations_per_min(r),manufacturer(m){}
        ~HardDisk(){}
        int getSize()const{return size;}
        int getRotationsPerMinute()const{return rotations_per_min;}
        string getManufacturer()const{return manufacturer;}
};

class Motherboard{
    private:
        string chipset_ver;
        int no_usb_ports;
        int max_ram;
        string manufacturer;
    public:
        Motherboard(string c, int u, int r, string m): chipset_ver(c),no_usb_ports(u),max_ram(r),manufacturer(m){}
        ~Motherboard(){}
        string getChipsetVersion()const{return chipset_ver;}
        int getNoUsbPorts()const{return no_usb_ports;}
        int getMaxRam()const{return max_ram;}
        string getManufacturer()const{return manufacturer;}
};  

class Computer{
    private:
        CPU cpu;
        RAM ram;
        HardDisk hardDisk;
        Motherboard motherboard;
        int year;
        float price;
    public:
        Computer(const CPU& cpu, const RAM& ram, const HardDisk& hardDisk, const Motherboard& motherboard, int year, float price): cpu(cpu), ram(ram), hardDisk(hardDisk), motherboard(motherboard), year(year), price(price){}
        ~Computer(){}

        void displayComputerInfo()const{
            cout<<"Computer Information:"<<endl;
            cout<<"CPU: "<<cpu.getClockFrequency()<<" GHz, "<<cpu.getInstructionSetArch()<<", "<<cpu.getType()<<" bit, "<<cpu.getNoRegisters()<<" registers, "<<cpu.getManufacturer()<<endl;
            cout<<"RAM: "<<ram.getSize()<<" GB, "<<ram.getType()<<", Producer "<<ram.getManufacturer()<<endl;
            cout<<"Hard Disk: "<<hardDisk.getSize()<<" GB, "<<hardDisk.getRotationsPerMinute()<<" RPM, "<<hardDisk.getManufacturer()<<endl;
            cout<<"Motherboard: Chipset "<<motherboard.getChipsetVersion()<<", "<<motherboard.getNoUsbPorts()<<" USB ports, Max. "<<motherboard.getMaxRam()<<" GB of RAM, "<<motherboard.getManufacturer()<<endl;
            cout<<"Year: "<<year<<endl;
            cout<<"Price: "<<price<<endl;
            cout<<"----------------------------------------------------------------------------"<<endl;
        }
};

int main(){
    CPU cpu1(3,"CISC",32,64,"AMD");
    RAM ram1(4,"DDR2","Kingston Hard");
    HardDisk hardDisk1(500,7200,"Maxtor");
    Motherboard motherboard1("AMD970",6,16,"AMD");
    Computer computer1(cpu1,ram1,hardDisk1,motherboard1,2019,482.5);

    CPU cpu2(4,"CISC",32,32,"INTEL");
    RAM ram2(8,"DDR3","Kingston Hard");
    HardDisk hardDisk2(1000,7200,"Seagate");
    Motherboard motherboard2("Intel Z77",6,64,"MSI");
    Computer computer2(cpu2,ram2,hardDisk2,motherboard2,2018,560.75);
    
    computer1.displayComputerInfo();
    computer2.displayComputerInfo();
}

