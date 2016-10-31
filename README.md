# JSensor and VANETs

This project was part of the Wireless Sensor Networks course at Federal University of Alagoas.

Course webpage: https://sites.google.com/site/allalinsufal/home/eletiva-1/20161

=====

### Description: 

A VANET is a Vehicular Ad-hoc Network, which consists of vehicle nodes and antennas also referred as Road Site Units (RSUs), this work tries to simulate a simple case of a VANET, where the nodes and antennas are deployed using a Grid algorithm, 
and the Vehicles are only allowed to communicate with each other using the RSUs, which describes a Infrastructure-To-Vehicle configuration (I2V). 

Our main goal is to analyze deployment problems onto Vehicular Ad-hoc Networks.
For more understading about the problem, try reading [1].

[1] Deif, D. S., & Gadallah, Y. (2014). Classification of wireless sensor networks deployment techniques. IEEE Communications Surveys and Tutorials, 16(2), 834–855. http://doi.org/10.1109/SURV.2013.091213.00018

The main aspect of the network are actually implemented in JSensor libraries.

JSensor: http://www.decom.ufop.br/imobilis/projetos/jsensor/

### How to execute: 

This repository contains the whole JSensor source code and examples projects, though the actual vanet projects it's into 
src/projects/vanet

Then, you can just clone this repository: 

```sh
$ git clone https://github.com/CristopherPK/JSensor.git

$ java -jar lib/JSensor.jar [path to .config file]
```

In our project: 

```sh
$ java -jar lib/JSensor.jar src/projects/vanet/vanet.config
```
To understand more about the JSensor projects configuration, try downloading this package: 

https://sourceforge.net/projects/javajsensor/

Which contains all the user guides of the simulator. 

