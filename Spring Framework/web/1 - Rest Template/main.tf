provider "aws" {
  region = "us-east-1"
}

resource "aws_security_group" "securitygroup" {
  name        = "ec2-securitygroup"
  description = "Ingress Http and SSH and Egress to anywhere "

  ingress {
    from_port   = 80
    to_port     = 80
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port   = 0
    to_port     = 65535
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_key_pair" "keypair" {
  key_name   = "terraform-keypair"
  public_key = file("C:/Users/Matheus/.ssh/id_rsa.pub")
}

resource "aws_instance" "servidor" {
  user_data              = file("user_data.sh")
  key_name               = aws_key_pair.keypair.key_name
  instance_type          = "t2.nano"
  ami                    = "ami-0c101f26f147fa7fd"
  vpc_security_group_ids = [aws_security_group.securitygroup.id]
}