from setuptools import setup, find_packages

setup(
    name='apiverve_nobelprizes',
    version='1.2.2',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Nobel Prizes searches laureate records by first name, last name, and award category. Each result includes the winner's full name, award year, and category, while paid plans add year filtering, motivations, and biographical details.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/nobelprizes?utm_source=pypi&utm_medium=referral&utm_content=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
