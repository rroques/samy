# Samy

[![Build Status](https://travis-ci.org/rroques/samy.svg?branch=master)](https://travis-ci.org/rroques/samy)
[![Dependency Status](https://dependencyci.com/github/rroques/samy/badge)](https://dependencyci.com/github/rroques/samy)
[![Issue Count](https://codeclimate.com/github/rroques/samy/badges/issue_count.svg)](https://codeclimate.com/github/rroques/samy)

A playground project for [AWS Serverless Application Model](https://github.com/awslabs/aws-sam-cli) in Java.

# Requirements

```
pip install sam-cli
```

# Usage

```
./gradlew build
sam local invoke SamyFunction --event event.json
```
