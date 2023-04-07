
def func(x):
    return x % 2 == 0


if __name__ == '__main__':
    import functools
    print(functools.reduce(lambda x, y: x * y, range(1, 5)))
    print([k for k in range(100) if (lambda x : x % 2 == 0)(k)])
    f = lambda x : x % 2 == 0
    print(f(2))
    