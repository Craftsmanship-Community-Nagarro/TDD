using FluentAssertions;
using Moq;
using Xunit;

namespace CSharpCore.Test;

public class HelloTest
{
    [Fact]
    public void ShouldGreet()
    {
        Hello hello = new Hello();

        string greeting = hello.Greetings();

        greeting.Should().Be("Hello!");
    }

    [Fact]
    public void ShouldStub()
    {
        Mock<Hello> helloStub = new Mock<Hello>();
        helloStub.Setup(hello => hello.Greetings()).Returns("Stub Hello!");

        string greeting = helloStub.Object.Greetings();

        greeting.Should().Be("Stub Hello!");
    }
}