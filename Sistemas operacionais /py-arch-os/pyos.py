import os
import curses
import pycfg
from pyarch import load_binary_into_memory
from pyarch import cpu_t

class os_t:
	def __init__ (self, cpu, memory, terminal):
		self.cpu = cpu
		self.memory = memory
		self.terminal = terminal

		self.terminal.enable_curses()

		self.console_str = ""
		self.command_line = ""
		self.terminal.console_print("this is the console, type the commands here\n 'exit' if you want stop\n>")
	
	def printk(self, msg):
		self.terminal.kernel_print("kernel: " + msg + "\n")

	def panic (self, msg):
		self.terminal.end()
		self.terminal.dprint("kernel panic: " + msg)
		self.cpu.cpu_alive = False
		#cpu.cpu_alive = False

	def interrupt_keyboard (self):
		key = self.terminal.get_key_buffer()
		
		if ((key >= ord('a')) and (key <= ord('z'))) or ((key >= ord('A')) and (key <= ord('Z'))) or ((key >= ord('0')) and (key <= ord('9'))) or (key == ord(' ')) or (key == ord('-')) or (key == ord('_')) or (key == ord('.')):
			strchar = chr(key)
			self.console_str += strchar 
			self.terminal.console_print(strchar)
			return
		if key == curses.KEY_BACKSPACE:
			self.console_str = self.console_str[0: len(self.console_str) - 1  ]
			self.terminal.console_print("\r" + self.console_str)
            #self.reset_top()
			
			return
		if (key == curses.KEY_ENTER) or (key == ord('\n')):
			
			self.console_comandos()
			self.terminal.console_print("\r")
			return
	
		
	def handle_interrupt (self, interrupt):
		if (interrupt == pycfg.INTERRUPT_KEYBOARD):
			self.interrupt_keyboard ()
		#elif (interrupt == pycfg.INTERRUPT_TIMER):
			#self.interrupt_timer ()
			#self.terminal.console_print("\nIninterrompendo o ciclo\n")
		#elif (interrupt == pycfg.INTERRUPT_MEMORY_PROTECTION_FAULT):
			#self.interrupt_memory_protection_fault ()
			#self.terminal.console_print("\nIninterrompendo memoria\n")
			

		return

	def syscall (self):
		
		#self.terminal.app_print(msg)
		return
		
	def console_comandos(self):		
		
		if( self.console_str == "exit"):	
			self.terminal.console_print("Bye Bye ...")
			self.terminal.end()
			self.cpu.cpu_alive = False
			

				
		
		
    
