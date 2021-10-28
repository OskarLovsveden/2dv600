---
title: 'Assignment 4 Report'
---

# Assignment 4 - ol222hf

## Table of Contents
[TOC]

# Exercises

## Exercise 1

Language used:
Σ = {0, 1}

### a) Strings that do not contain 11

regex = (0|10)*1?

![ex1_a.drawio](C:\www\school\2DV600\src\ol222hf_assign4\ex1_a.drawio.png) 

### b) Strings that contain at least four symbols

regex = (0|1)(0|1)(0|1)(0|1)+

![ex1_b.drawio](C:\www\school\2DV600\src\ol222hf_assign4\ex1_b.drawio.png) 

### c) Strings where each 1 is directly followed by 0

regex = (0|10)*

![ex1_c.drawio](C:\www\school\2DV600\src\ol222hf_assign4\ex1_c.drawio.png) 

### d) Strings that both start and end with 10

10(1|0)*10

### e) Strings having an odd number of 0s and an odd number of 1s

regex = 

odd 1s ---> 0\*1(0|10\*1)\*
odd 0s ---> 1\*0(1|01\*0)*

